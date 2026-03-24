package mk.ukim.finki.emt.emtlab.jobs;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import mk.ukim.finki.emt.emtlab.repository.MaterializedBookViewRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MaterializedViewRefreshScheduler {
    private final MaterializedBookViewRepository materializedBookViewRepository;

    public MaterializedViewRefreshScheduler(MaterializedBookViewRepository materializedBookViewRepository) {
        this.materializedBookViewRepository = materializedBookViewRepository;
    }

    @Scheduled(cron = "0 * * * * *")
    @Transactional
    public void refreshMaterializedBookView() {
        log.info("Refreshing MATERIALIZED_BOOK_VIEW...");
        materializedBookViewRepository.refresh();
        log.info("MATERIALIZED_BOOK_VIEW successfully refreshed.");
    }

}
