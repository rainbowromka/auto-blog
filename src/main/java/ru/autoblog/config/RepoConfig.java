package ru.autoblog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author Roman Perminov *
 * Конфигурация репозитория. Конкретно разрешаем аудит сущностей.
 *
 * TODO: разобраться в будущем, зачем это нужно и чем полезно.
 */
@Configuration
@EnableJpaAuditing
public class RepoConfig {
}
