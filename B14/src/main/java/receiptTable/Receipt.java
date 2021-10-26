package receiptTable;

import entity.NguoiMuaVe;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Receipt {
    NguoiMuaVe nguoiMuaVe;
    List<TicketTable> ticketTables = new ArrayList<>();
    int sum;
    float priceTotal;

    public Receipt(NguoiMuaVe nguoiMuaVe, List<TicketTable> ticketTables) {
        this.nguoiMuaVe = nguoiMuaVe;
        this.ticketTables = ticketTables;
    }
}
