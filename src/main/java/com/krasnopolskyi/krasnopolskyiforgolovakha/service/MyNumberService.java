package com.krasnopolskyi.krasnopolskyiforgolovakha.service;

import com.krasnopolskyi.krasnopolskyiforgolovakha.data.MyNumberRepository;
import com.krasnopolskyi.krasnopolskyiforgolovakha.entity.MyNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyNumberService {

    private final MyNumberRepository myNumberRepository;


    public Optional<MyNumber> getCount() {
        return myNumberRepository.getCount();
    }

    public void saveCount() {
        if (getCount().isPresent()) {
            myNumberRepository.saveCounter(getCount().get().getCount() + 1);
        }
    }
}
