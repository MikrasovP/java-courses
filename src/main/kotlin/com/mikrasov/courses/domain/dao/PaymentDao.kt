package com.mikrasov.courses.domain.dao

import com.mikrasov.courses.domain.model.Payment
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentDao : JpaRepository<Payment, Long> {
}