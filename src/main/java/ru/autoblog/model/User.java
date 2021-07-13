package ru.autoblog.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Romen Perminov
 * Класс пользователя. По нему мы будем авторизироваться в системе.
 */
@Entity
@Table(name = "users", schema = "autoblog")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
        name = "jpaUserSequence",
        allocationSize = 1,
        schema = "autoblog",
        sequenceName = "user_sequence"
)
public class User
{
    /**
     * Id пользователя.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "jpaUserSequence")
    private Long id;

    /**
     * Имя пользователя.
     */
    private String userName;

    /**
     * Пароль.
     */
    private String password;

    /**
     * Роль.
     */
    private String role;
}
