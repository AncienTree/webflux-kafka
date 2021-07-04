package com.accenture.kafkawebflux.model

import spock.lang.Specification
import spock.lang.Unroll

class UserTest extends Specification{

    def "new user should have false flag"() {
        given:
        def user = new User(new UserDTO("Test", 1));

        expect:
        !user.isFlag();
    }

    @Unroll
    def "new user with #score should return is odd #result"(int score, boolean result) {
        given:
        def user = new User(new UserDTO("Test", score));

        expect:
        user.isOddScore() == result

        where:
        score | result
        123   | true
        12    | false
        0     | false
    }
}
