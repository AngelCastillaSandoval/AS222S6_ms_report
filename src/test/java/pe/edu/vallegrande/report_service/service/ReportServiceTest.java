package pe.edu.vallegrande.report_service.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.edu.vallegrande.report_service.model.Report;
import pe.edu.vallegrande.report_service.repository.ReportRepository;
import pe.edu.vallegrande.report_service.repository.ReportWorkshopRepository;
import pe.edu.vallegrande.report_service.repository.WorkshopCacheRepository;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class ReportServiceTest {

    @Mock
    private ReportRepository reportRepository;

    @Mock
    private ReportWorkshopRepository reportWorkshopRepository;

    @Mock
    private WorkshopCacheRepository workshopCacheRepository;

    @Mock
    private SupabaseStorageService supabaseStorageService;

    @InjectMocks
    private ReportService reportService;

    @BeforeEach
    void setUp() {
        // No se necesita configuración manual si usas @InjectMocks y @Mock
    }

    @Test
    void shouldReturnEmptyWhenNoReportsExist() {
        // Arrange: simula que no hay reportes
        Mockito.when(reportRepository.findAll()).thenReturn(Flux.empty());

        // Act & Assert
        StepVerifier.create(reportService.findFilteredReports(null, null, null, null, null))
                .expectNextCount(0)
                .verifyComplete();
    }
}
