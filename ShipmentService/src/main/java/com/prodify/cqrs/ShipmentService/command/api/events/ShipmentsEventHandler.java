package com.prodify.cqrs.ShipmentService.command.api.events;

import com.prodify.cqrs.CommonService.events.OrderShippedEvent;
import com.prodify.cqrs.ShipmentService.command.api.data.Shipment;
import com.prodify.cqrs.ShipmentService.command.api.data.ShipmentRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ShipmentsEventHandler {

    private ShipmentRepository shipmentRepository;

    public ShipmentsEventHandler(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @EventHandler
    public void on(OrderShippedEvent event) {
        Shipment shipment
                = new Shipment();
        BeanUtils.copyProperties(event,shipment);
        shipmentRepository.save(shipment);
    }
}
