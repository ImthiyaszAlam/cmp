package com.imthiyas.kaamai

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform