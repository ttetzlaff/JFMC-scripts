artifactory('art2'){
  
  localRepository('repo11') {
    description "Public description"
    notes "Some internal notess"  
    includesPattern "**/*" // default
    excludesPattern "" // default  
    xrayIndex false
    propertySets // (["ps1", "ps2"])
    archiveBrowsingEnabled false
    blackedOut false // default
    packageType "npm"   
  }  
}


artifactory('art') {

  localRepository("repo11") {
    description "Public description"
    notes "Some internal notes"
    archiveBrowsingEnabled false
    packageType "npm" 

    replication("http://localhost:8081/artifactory/repo11") {
      cronExp "0 0/9 14 * * ?"
      socketTimeoutMillis 15000
      username "remote-repo-user"
      password "pass"
      proxy //"proxy-ref"
      enableEventReplication true
      enabled true
      syncDeletes false
      syncProperties true
    }
  }
}