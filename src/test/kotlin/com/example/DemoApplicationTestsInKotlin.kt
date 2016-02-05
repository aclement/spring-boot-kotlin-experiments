/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner::class)
@SpringApplicationConfiguration(classes = arrayOf(DemoApplication::class))
@WebAppConfiguration
public class DemoApplicationTestsInKotlin {
	@Autowired
	lateinit var customerRepository: CustomerRepository

	@Test
	fun thisAndThat() {
		var customer = Customer()
		customer.firstName = "Jane"
		customer.lastName = "Doe"
		customer = customerRepository.save(customer)
		// ID 1 is taken up with John Doe built in the application PostConstruct method
		var customer2 = customerRepository.findOne(1L)
		Assert.assertEquals("John",customer2.firstName)
		customer2 = customerRepository.findOne(2L)
		Assert.assertEquals("Jane",customer2.firstName)
	}

}
