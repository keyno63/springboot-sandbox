package jp.co.who.spring_tutorial.teratail.q341428.controller;

import jp.co.who.spring_tutorial.teratail.q341428.service.MemberService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

@Controller
public class MemberController {

    private MemberService memberService;

    private ExecutorService executor;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
        executor = Executors.newFixedThreadPool(1);
    }

    @GetMapping("/q341428/export")
    public ResponseEntity<Resource> exportExcel() {

        List<String> memberList = List.of("1", "2", "3");
        Supplier<Integer> initValueSupplier = () -> memberService.delayExport(memberList);

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(initValueSupplier,
                executor);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .headers(new HttpHeaders())
                .body(new ByteArrayResource( new byte[0]));
    }

}
