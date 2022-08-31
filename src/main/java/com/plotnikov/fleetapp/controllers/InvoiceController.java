package com.plotnikov.fleetapp.controllers;

import com.plotnikov.fleetapp.models.Client;
import com.plotnikov.fleetapp.models.Country;
import com.plotnikov.fleetapp.models.Invoice;
import com.plotnikov.fleetapp.models.InvoiceStatus;
import com.plotnikov.fleetapp.services.ClientService;
import com.plotnikov.fleetapp.services.CountryService;
import com.plotnikov.fleetapp.services.InvoiceService;
import com.plotnikov.fleetapp.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceController {

    @Autowired private InvoiceService invoiceService;
    @Autowired private ClientService clientService;
    @Autowired private InvoiceStatusService invoiceStatusService;

    @GetMapping("/invoices")
    public String getInvoices(Model model) {
        List<Invoice> invoiceList = invoiceService.getInvoices();
        model.addAttribute("invoices", invoiceList);

        List<Client> clientList = clientService.getClients();
        model.addAttribute("clients", clientList);

        List<InvoiceStatus> invoiceStatuses = invoiceStatusService.getInvoiceStatuses();
        model.addAttribute("invoiceStatuses", invoiceStatuses);

        return "invoice";
    }

    @PostMapping("/invoices/addNew")
    public String addNew(Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping("/invoices/findById")
    @ResponseBody
    public Optional<Invoice> findById(Integer id) {
        return invoiceService.findById(id);
    }

    @RequestMapping(value = "/invoices/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping(value = "/invoices/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        invoiceService.delete(id);
        return "redirect:/invoices";
    }
}
