# kubernetes-playground

Nothing fancy here. Just for trying out K8s E2E lifecycle.

* Uses Google Container Tool's Skaffold and Jib to build and push the image
* Spring boot app - needs mongodb host as MONGO_HOST env variable
* Also integrates with Datadog for monitoring - You can inject API and APP key using env variables
* Uses SealedSecrets

