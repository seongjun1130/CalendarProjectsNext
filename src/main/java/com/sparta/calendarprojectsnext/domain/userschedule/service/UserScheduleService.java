package com.sparta.calendarprojectsnext.domain.userschedule.service;

import com.sparta.calendarprojectsnext.domain.exception.CustomException;
import com.sparta.calendarprojectsnext.domain.schedule.repository.ScheduleRepository;
import com.sparta.calendarprojectsnext.domain.user.entity.User;
import com.sparta.calendarprojectsnext.domain.user.repository.UserRepository;
import com.sparta.calendarprojectsnext.domain.userschedule.command.UserScheduleCommand;
import com.sparta.calendarprojectsnext.domain.userschedule.dto.UserScheduleAssignRequestDto;
import com.sparta.calendarprojectsnext.domain.userschedule.dto.UserScheduleAssignResponseDto;
import com.sparta.calendarprojectsnext.domain.userschedule.entity.UserSchedule;
import com.sparta.calendarprojectsnext.domain.userschedule.mapper.UserScheduleMapper;
import com.sparta.calendarprojectsnext.domain.userschedule.repository.UserScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.sparta.calendarprojectsnext.domain.exception.eunm.ErrorCode.*;

@Service
@RequiredArgsConstructor
@Transactional
public class UserScheduleService {
    private final UserScheduleRepository userScheduleRepository;
    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;
    private final UserScheduleMapper userScheduleMapper;

    public UserScheduleAssignResponseDto assignUser(UserScheduleAssignRequestDto uarDto) {
        UserSchedule userSchedule = UserScheduleCommand.Create.toUserSchedule(uarDto, scheduleRepository, userRepository);
        User creator = userRepository.findById(uarDto.getCreateUserId()).orElseThrow(() -> new CustomException(USER_NOT_FOUND));
        if (userSchedule.isValidateCreator(creator.getId())) {
            throw new CustomException(NOT_CREATOR);
        }
        if (userScheduleRepository.existsByUserIdAndScheduleId(userSchedule.getUser().getId(), userSchedule.getSchedule().getId())) {
            throw new CustomException(ALREADY_ASSIGN_USER);
        }
        userScheduleRepository.save(userSchedule);
        return userScheduleMapper.UserScheduleToUserScheduleDto(userSchedule);
    }

}
