package org.msa.service.rental.domain.event;


import lombok.Getter;
import lombok.NoArgsConstructor;
import org.msa.service.rental.domain.vo.IdName;
import org.msa.service.rental.domain.vo.Item;

@NoArgsConstructor
@Getter
public class ItemReturned extends ItemRented {

    public ItemReturned(IdName idName, Item item, long point) {
        super(idName, item, point);
    }
}
