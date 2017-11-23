all = userInput(type: "ARTIFACTORY", multivalued: true, description: "All Instances")

for (instance in all) {
  artifactory(instance.name){

      localRepository('repo-docker') {
        description "Public description"
        notes "Some internal notes"
        archiveBrowsingEnabled false
        blackedOut false // default
        packageType 'docker'
      }   

      remoteRepository('remote-rpm') {
        description "Public description"
        notes "Some internal notes"
        includesPattern "**/*" // default
        excludesPattern "" // default
        propertySets // (["ps1", "ps2"])
        archiveBrowsingEnabled false
        url "http://ubuntu:8081/local-rpm"
        username "remote-repo-user"
        password "pass"
        proxy "proxy-ref"
        socketTimeoutMillis 15000
        localAddress "123.123.123.123"
        assumedOfflinePeriodSecs 300
        listRemoteFolderItems true        
        packageType "rpm"  
      }

      virtualRepository('virtual-docker') {
        description "Public description"
        notes "Some internal notes"
        includesPattern "**/*" // default
        excludesPattern "" // default
        repositories (["example-repo-local"]) // values (["local-rep1", "local-rep2", ...]) are examples. Please set existing values from the instance 
        artifactoryRequestsCanRetrieveRemoteArtifacts false
        defaultDeploymentRepo ""  
        packageType "docker"
        forceDockerAuthentication false
	}
  }   
}