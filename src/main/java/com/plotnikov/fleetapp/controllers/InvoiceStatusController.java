package com.plotnikov.fleetapp.controllers;

import com.plotnikov.fleetapp.models.InvoiceStatus;
import com.plotnikov.fleetapp.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceStatusController {

    @Autowired private InvoiceStatusService invoiceStatusService;

    @GetMapping("/invoice_statuses")
    public String getInvoiceStatuses(Model model) {
        List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatuses();

        model.addAttribute("invoice_statuses", invoiceStatusList);

        return "invoice_status";
    }

    @PostMapping("/invoice_statuses/addNew")
    public String addNew(InvoiceStatus invoiceStatus) {
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoice_statuses";
    }

    @RequestMapping("/invoice_statuses/findById")
    @ResponseBody
    public Optional<InvoiceStatus> findById(Integer id) {
        return invoiceStatusService.findById(id);
    }

    @RequestMapping(value = "/invoice_statuses/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(InvoiceStatus invoiceStatus) {
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoice_statuses";
    }

    @RequestMapping(value = "/invoice_statuses/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        invoiceStatusService.delete(id);
        return "redirect:/invoice_statuses";
    }
}
