package com.example.demo.starter.module.following.api;

import com.example.demo.starter.module.following.api.model.ToggleAnswerRequest;
import com.example.demo.starter.module.following.application.dto.FollowDto;
import com.example.demo.starter.module.following.application.service.FollowingService;
import com.example.demo.starter.shared.base.controller.BaseController;
import com.example.demo.starter.shared.util.response.ServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/following")
@RequiredArgsConstructor
public class FollowingController extends BaseController {
    private final FollowingService service;

    @PostMapping
    public ResponseEntity<ServiceResponse<FollowDto>> create(@RequestBody FollowDto dto) {
        return controllerResponse(service.create(dto));
    }
    @PostMapping("/accept")
    public ResponseEntity<ServiceResponse<FollowDto>> accept(@RequestBody ToggleAnswerRequest request) {
        return controllerResponse(service.accept(request.followerId(), request.followingId()));
    }
    @PostMapping("/reject")
    public ResponseEntity<ServiceResponse<FollowDto>> reject(@RequestBody ToggleAnswerRequest request) {
        return controllerResponse(service.reject(request.followerId(), request.followingId()));
    }
}
