package br.com.cwi.jdbi.techtalkdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private Long id;

    private String name;

    private Integer age;

    private Gender gender;

    private String job;

    private String description;

}
