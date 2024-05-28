package com.example.web_3

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component

@Component
class SpringContext : ApplicationContextAware {
    companion object {
        private lateinit var context: ApplicationContext

        fun <T> getBean(beanClass: Class<T>): T {
            return context.getBean(beanClass)
        }
    }

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        context = applicationContext
    }
}
