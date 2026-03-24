package mk.ukim.finki.emt.emtlab.model.dto;

import mk.ukim.finki.emt.emtlab.model.enums.Category;
import mk.ukim.finki.emt.emtlab.model.views.MaterializedBookView;

import java.util.List;

public record DisplayMaterializedBookViewDto(
        Category category,
        Integer totalBooks,
        Integer totalCopies,
        Integer totalBadBooks
) {
    public static DisplayMaterializedBookViewDto from(MaterializedBookView materializedBookView) {
        return new DisplayMaterializedBookViewDto(
                materializedBookView.getCategory(),
                materializedBookView.getTotalBooks(),
                materializedBookView.getTotalCopies(),
                materializedBookView.getTotalBadBooks()
        );
    }
    public static List<DisplayMaterializedBookViewDto> from(List<MaterializedBookView> materializedBookViews){
        return materializedBookViews
                .stream()
                .map(DisplayMaterializedBookViewDto::from)
                .toList();
    }
}
