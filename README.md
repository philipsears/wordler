# wordler - philipsears

Wordler program can take randomly inputed letters and find all the words that can be spelled with them

## Requirements

Wordler requires scala and sbt.  
A dictionary file is also required.

## Configure

Configuring wordler can be done by changing com.philipsears.wordler.WordlerConfig file

You will need to configure the dictionary path.  
A default dictionary is committed in the source in $project/src/main/resources/en-US.dic

## Build

Building wordler is easy

	sbt compile

Clean build can be done like this
	
	sbt clean compile

## Run

Running wordler can be done by starting sbt 

	sbt

and starting run command

	run

