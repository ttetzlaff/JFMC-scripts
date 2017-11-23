art = userInput (
    name : "Artifactory", 
    type : "ARTIFACTORY",    
    description : "please provide a value"
  )

pkgtype = userInput (
    name : "Package type", 
    type : "PACKAGE_TYPE", 
    description : "please provide a value"
  )

localreponame = userInput (
    name : "Local repo name", 
    type : "STRING",  
    description : "please provide a value"
  )

artifactory(art.name){
	localRepository(localreponame) {
      description "Public description"
      notes "Some internal notes"
      archiveBrowsingEnabled false
      packageType pkgtype
    }
}