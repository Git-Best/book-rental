package org.msa.service.member.domain.event;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.msa.service.member.domain.vo.IdName;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ItemRented implements Serializable {
    private IdName idName;
    private Item item;
    private long point;
}
