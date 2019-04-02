package com.ashay.pet.k8s_deployment_patcher

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class K8sDeploymentPatcherApplication {

	static void main(String[] args) {
		SpringApplication.run(K8sDeploymentPatcherApplication, args)
	}

}
