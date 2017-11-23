artifactory('art') {
  localRepository('repo14') {
    description "Public descriptions"
    notes "Some internal notes"
    includesPattern "**/*"
    excludesPattern ""
    xrayIndex false
    archiveBrowsingEnabled false
    blackedOut false 
    packageType "gradle" 
    maxUniqueSnapshots 0 
    handleReleases true 
    handleSnapshots true 
    suppressPomConsistencyChecks false 
    snapshotVersionBehavior "unique" 
    checksumPolicyType "client-checksums" 
 }
}