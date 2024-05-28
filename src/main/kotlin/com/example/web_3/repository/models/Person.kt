package com.example.web_3.repository.models

import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Модель пользователя. Того, который использует пиложение, а не записан в базу данных. Может дополняться полями для
 * ссылки на карзину покупок, или что еще будет нужно в процессе работы с ним.
 */
@Component("personinfo")
@Scope("prototype")
class Person {
    var login: String? = null
    var password: String? = null
}


