package com.example.demo.validator;

import org.junit.jupiter.api.Test;
//import org.assertj.core.api.Assertions.*;

class EmailValidatorTest {

   private final EmailValidator email = new EmailValidator();
    @Test
   public void validEmail(){
       assert(email.test("temam@gmail.com"));
   }

    @Test
    public void inValidEmail(){
        assert(email.test("temamgmail.com"));
    }

}