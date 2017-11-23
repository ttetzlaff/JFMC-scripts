all = userInput(
  type: "ARTIFACTORY", 
  multivalued: true, 
  description: "All Instances"
)

for(instance in all){
  artifactory(instance.name){
      
      localRepository('repo-yum') {
        description "Public description"
        notes "Some internal notes"
        archiveBrowsingEnabled false
        blackedOut false // default
        packageType 'yum'
      }
      
      localRepository('repo-rpm') {
        description "Public description"
        notes "Some internal notes"
        archiveBrowsingEnabled false
        blackedOut false // default
        packageType 'rpm'
      }

      remoteRepository('remote-rpm') {
        description "Public description"
        notes "Some internal notes"
        includesPattern "**/*" // default
        excludesPattern "" // default
        repoLayoutRef "maven-2-default"
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
  }   
}