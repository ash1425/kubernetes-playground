package com.ashay.pet.k8s_deployment_patcher

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ImageUpdateListener {

    private final static Logger log = LoggerFactory.getLogger(ImageUpdateListener.class)

    @PostMapping("/image")
    def consumeUpdate(@RequestBody Map imageUpdate) {
        log.info("received updated image {} with tag {}", imageUpdate.repository.repo_name, imageUpdate.push_data.tag)
    }
}

