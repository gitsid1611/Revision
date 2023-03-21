package com.example.Module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer slotId;

    @NotNull(message="startTime can't be null ")
    @NotEmpty(message = "startTime cannot be empty ")
    @NotBlank(message = "startTime cannot be blank ")
    private LocalDateTime startTime;

    @NotNull(message="endTime can't be null ")
    @NotEmpty(message = "endTime cannot be empty ")
    @NotBlank(message = "endTime cannot be blank ")
    private LocalDateTime endTime;

    @OneToMany
    private List<Trainer> trainers;

}
