package org.example.client;

import org.example.config.FeignClientConfig;
import org.example.dto.DocumentEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "document-content-client", url = "http://localhost:8092", configuration = FeignClientConfig.class)
public interface DocContentFeignClient {
    @GetMapping(value = "/documentale-content/docs/{documentId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DocumentEntity> fetchDocumentById(@PathVariable(name = "documentId") Long documentId);

    //    @GetMapping(value = "/api/availability/{idChannel}/product/{productCode}/resources/{resourceType}")
    //    public ResourcesByProductResponse getResourcesByProduct(@PathVariable(name = "idChannel") UUID idChannel,
    //                                                            @PathVariable(name = "productCode") String productCode,
    //                                                            @PathVariable(name = "resourceType") String resourceType);
    //
    //    @GetMapping(value = "/api/availability/{idChannel}/resource/{resourceId}/{resourceType}/products")
    //    public ProductsByResourceResponse getProductsByResource(@PathVariable(name = "idChannel") UUID idChannel,
    //                                                            @PathVariable(name = "resourceId") String resourceId,
    //                                                            @PathVariable(name = "resourceType") String resourceType);
    //
    //    @GetMapping(value = "/api/activities/getCatalogue")
    //    public ActivitiesResponse getProducts(@RequestParam(name = "idChannel") UUID idChannel,
    //                                          @RequestParam(name = "onlySynonym") boolean onlySynonym,
    //                                          @RequestParam(name = "term", required = false) String name);
    //
    //    @PostMapping(value = "/api/availability/{idChannel}/first")
    //    public List<AvailabilityResponse> getFirstAvailability(@PathVariable(name = "idChannel") UUID idChannel,
    //                                                           @RequestBody List<AvailabilityFirstRequest> body);
    //
    //    @PostMapping(value = "/api/availability/{idChannel}/search")
    //    public List<AvailabilityResponse> getAllAvailability(@PathVariable(name = "idChannel") UUID idChannel,
    //                                                         @RequestBody List<AvailabilityAllRequest> body);
    //
    //    @PostMapping(value = "/api/order/list")
    //    public List<Reservation> getReservations(@RequestBody ReservationsRequest body);
    //
    //    @PostMapping(value = "/api/availability/{idChannel}/reserve")
    //    public SlotReservationResponse reserveSlots(@PathVariable(name = "idChannel") UUID idChannel,
    //                                                @RequestBody List<ReserveRequest> body);
    //
    //    @PostMapping(value = "/api/availability/{idChannel}/confirmreserve")
    //    public ConfirmationResponse confirmReservations(@PathVariable(name = "idChannel") UUID idChannel,
    //                                                    @RequestBody List<ConfirmReserveRequest> body);
    //
    //    @PostMapping(value = "/api/availability/{idChannel}/cancelappointment")
    //    public List<AppointmentCancellationResponse> cancelAppointment(@PathVariable(name = "idChannel") UUID idChannel,
    //                                                                   @RequestBody List<String> body);
    //
    //    @PutMapping(value = "/api/availability/{channelId}/{slotId}/closure")
    //    public BaseResultResponse addClosure(@PathVariable(name = "channelId") UUID channelId,
    //                                         @PathVariable(name = "slotId") UUID slotId,
    //                                         @RequestBody NewClosureRequest newClosure);
    //
    //    @DeleteMapping(value = "/api/availability/{channelId}/{slotId}/{closureId}")
    //    public BaseResultResponse removeClosure(@PathVariable(name = "channelId") UUID channelId,
    //                                            @PathVariable(name = "slotId") UUID slotId,
    //                                            @PathVariable(name = "closureId") UUID closureId);
    //
    //    @PutMapping(value = "/api/availability/{channelId}/{slotId}/opening")
    //    public BaseResultResponse modifyOpening(@PathVariable(name = "channelId") UUID channelId,
    //                                            @PathVariable(name = "slotId") UUID slotId,
    //                                            @RequestBody ModifyOpeningRequest opening);
    //
    //    @DeleteMapping(value = "/api/availability/{channelId}/{slotId}/opening")
    //    public BaseResultResponse removeOpening(@PathVariable(name = "channelId") UUID channelId,
    //                                            @PathVariable(name = "slotId") UUID slotId,
    //                                            @RequestBody RemoveOpeningRequest opening);
    //
    //    @GetMapping(value = "/api/availability/{channelId}/GetContracts")
    //    public ContractsResponse getContracts(@PathVariable(name = "channelId") UUID channelId,
    //                                          @RequestParam(name = "term", required = false) String term);

}