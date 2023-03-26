package com.vetrix.network_API.demo.topic;


import com.vetrix.network_API.demo.ue.Ue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Table(name = "topic")
@Entity
public class Topic {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private UUID id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_topic",referencedColumnName = "id")
    private List<Ue> ueList;

    public Topic() {
    }
}
