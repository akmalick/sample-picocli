
import groovy.transform.Field

//import groovy.cli.picocli.CliBuilder

import picocli.CommandLine
import picocli.groovy.PicocliScript2

@GrabConfig(systemClassLoader = true)
@Grapes([
//        @Grab(group = 'info.picocli', module = 'picocli', version = '4.7.5'),//---->No more works in newer picocli
        @Grab(group = 'info.picocli', module = 'picocli-groovy', version = '4.7.5'),
        @GrabExclude("info-picocli:picocli"),
        @Grab(group = 'org.fusesource.jansi', module = 'jansi', version = '2.4.1')
])

@PicocliScript2

@CommandLine.Command(name = "samplePicoCli",
        mixinStandardHelpOptions = true, // add --help and --version options
        description = """\r\n @|bold Description:|@ Scaffold Groovy script to recreate the common issues faced during compilation 

Example :

groovy sample-picocli.groovy @|fg(yellow) --first-name|@=@|fg(cyan) <firstName>|@ @|fg(yellow) --last-name|@=@|fg(cyan) <lastName>|@

where
    @|italic,fg(cyan) <firstName>|@ = "asif"
    @|italic,fg(cyan) <lastName> |@    = "malick"
    
@|bold Common commandline options available with this script:|@
""",
        sortOptions = false
        ,requiredOptionMarker = '*' //---->>>>> This DOES"T WORK

)

@CommandLine.Option(names = ["--first-name"], paramLabel = "firstName", required = true, description = "Mandatory first name")
@Field String firstNameArg

@CommandLine.Option(names = "--last-name", paramLabel = "lastName", required = true, description = "Mandatory last name")
@Field String lastNameArg

@CommandLine.Option(names = "--middle-name", paramLabel = "middleName", arity = "0..1", required = false,
        description = "Optional middle name")
@Field String middleNameArg
