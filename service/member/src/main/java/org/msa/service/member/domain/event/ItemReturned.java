package org.msa.service.member.domain.event;


import lombok.Getter;
import lombok.NoArgsConstructor;
import org.msa.service.member.domain.vo.IdName;

@NoArgsConstructor
@Getter
public class ItemReturned extends ItemRented {

    public ItemReturned(IdName idName, Item item, long point) {
        super(idName, item, point);
    }
}
