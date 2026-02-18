import java.util.*;
import java.util.stream.*;

public class Reconciler {

    public Stream<PendingTransaction> reconcile(
            Stream<PendingTransaction> pending,
            Stream<Stream<ProcessedTransaction>> processed) {

        if (pending == null) {
            return Stream.empty();
        }

        Set<Long> processedIds = new HashSet<>();

        if (processed != null) {
            processed.forEach(inner -> {
                if (inner != null) {
                    inner.forEach(pt -> {
                        if (pt != null
                                && pt.getId() != null
                                && !pt.getId().isEmpty()
                                && pt.getStatus() != null
                                && pt.getStatus().isPresent()
                                && "DONE".equalsIgnoreCase(pt.getStatus().get())) {

                            try {
                                processedIds.add(Long.valueOf(pt.getId()));
                            } catch (NumberFormatException ignored) {
                            }
                        }
                    });
                }
            });
        }

        return pending
                .filter(Objects::nonNull)
                .filter(p -> processedIds.contains(p.getId()));
    }
}
