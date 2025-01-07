package org.msa.service.rental.domain.event;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.msa.service.rental.domain.vo.IdName;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OverdueCleared implements Serializable {
    private IdName idName;
    private long point;
}
