package FoodPair.foodpair.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter @Setter
@AllArgsConstructor
public class UpdatePostDto {

    private Long id;

    private Long uuid;

    private Integer viewCount;

    private Integer commentConut;

    private Integer likeConut;

    private String content;

    private String imageSrc;

    private Boolean anonStatus;

    private Integer wineId;

    private LocalDateTime createAt;

    // 9개로 받아서 변화된 부분만 체크
    private Long[] changeIndex;



}
