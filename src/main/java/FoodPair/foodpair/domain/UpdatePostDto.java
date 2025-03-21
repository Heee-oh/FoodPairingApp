package FoodPair.foodpair.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter @Setter
@AllArgsConstructor
public class UpdatePostDto {



    private String content;

    private Boolean anonStatus;

    private Integer wineId;

    private LocalDateTime createAt;




}
