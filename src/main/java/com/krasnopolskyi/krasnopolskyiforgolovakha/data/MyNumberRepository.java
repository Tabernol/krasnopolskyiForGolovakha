package com.krasnopolskyi.krasnopolskyiforgolovakha.data;

import com.krasnopolskyi.krasnopolskyiforgolovakha.entity.MyNumber;

import java.util.Optional;

public interface MyNumberRepository {

   Optional<MyNumber> getCount();

   void saveCounter(Integer count);
}
