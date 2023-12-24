package com.mappingbasics.basesmapping.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data @NoArgsConstructor  @AllArgsConstructor
@Component
public class MyComponent {

    private String name;
    private int value;

    @Override
    public String toString() {
        return "MyComponent{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
