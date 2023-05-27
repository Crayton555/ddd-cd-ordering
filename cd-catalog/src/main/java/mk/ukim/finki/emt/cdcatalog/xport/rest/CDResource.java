package mk.ukim.finki.emt.cdcatalog.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.cdcatalog.domain.models.CD;
import mk.ukim.finki.emt.cdcatalog.services.CDService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cd")
@AllArgsConstructor
public class CDResource {

    private final CDService cdService;

    @GetMapping
    public List<CD> getAll() {
        return cdService.getAll();
    }

}