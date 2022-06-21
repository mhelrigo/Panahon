package com.mhelrigo.domain;

public abstract class BaseUseCase<T, PARAMS> {
   public BaseUseCase() {

   }

   public abstract T execute(PARAMS params);
}
