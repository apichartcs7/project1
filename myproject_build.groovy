// MyProject-Build.groovy

// def gitUrl = "https://github.com/apichartcs7/project1.git"

// job("MyProject-Build") {
//     description "Builds MyProject from master branch."
//     parameters {
//         stringParam('COMMIT', 'HEAD', 'Commit to build')
//     }
//     scm {
//         git {
//             remote {
//                 url gitUrl.
//                 //branch "origin/master"
//             }
//             extensions {
//                 wipeOutWorkspace()
//                 localBranch master
//             }
//         }
//     }
//     steps {
//         shell "Look: I'm building master!"
//     }
// }

job('DSL-Tutorial-1-Test') {
    scm {
        git('git://github.com/apichartcs7/project1.git')
    }
    triggers {
        scm('H/15 * * * *')
    }
    steps {
        maven('-e clean test')
    }
}
