package org.cardoza.sec09.application;

import org.cardoza.common.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public record Order(Integer userId, String productName, Integer price) {
}
