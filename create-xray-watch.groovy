xrayService = userInput (
    name : "Xray service", // Optional
    type : "XRAY",    
    description : "Please provide a value"
)

binaryManager = userInput (
  name : "Xray binary manager", // Optional
    type : "ARTIFACTORY",    
    description : "Please provide a value"
)

watchName = userInput (
    name : "Watch name", 
    type : "STRING", 
    description : "please provide a value"
)

repoName = userInput (
    name : "Repo name", 
    type : "STRING", 
    description : "please provide a value"
)

xray(xrayService.name) {
  watch(watchName) {
    binaryManagerId binaryManager.name
    targetType "repository"
    description "test description"
    active: true        
    repoType "maven"
    targetName repoName
    filters {
      filter {
        type 'license_black'
        value(['Apache-2.0', 'Apache-1.1'])
      }      
    }
  }
}