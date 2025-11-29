package com.example.demo.starter.module.module1.domain.entity;

import com.example.demo.starter.module.module1.domain.event.Module1CreatedEvent;
import com.example.demo.starter.shared.kernel.domain.AggregateRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter
@Table(name = "module1")
@NoArgsConstructor @AllArgsConstructor
public class Module1Entity extends AggregateRoot {
    private String name;

    public static Module1Entity create(String name) {
        Module1Entity entity = new Module1Entity();
        entity.setName(name);
        entity.registerEvent(new Module1CreatedEvent(name));
        return entity;
    }
}
