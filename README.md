##In order to use Jenkins job builder just complete a few simple steps:


1. Install Jenkins job builder on your local machine: 

    **sudo pip install jenkins-job-builder**

2. Create directory **/etc/jenkins_jobs/** on the local machine and put there **jenkins_jobs.ini** file with the next parameters:
  
       [job_builder]
       ignore_cache=True
       keep_descriptions=False
       include_path=.:scripts:~/git/
       recursive=False
       exclude=.*:manual:./development
       allow_duplicates=False
           
       [jenkins]
       user=<jenkinsUsername>
       password=<jenkinsUserApiToken> # Go to http://grid2.et.eng.bos.redhat.com/me/configure and click Show API token to get it
       url=http://grid2.et.eng.bos.redhat.com
       query_plugins_info=False
            
Set the user, password and url according your settings in Jenkins

   
3.Go to the directory **rhoads-scripts** make sure that it contains **jobs** directory with yaml templates

4.(Optionally) You can run the job builder in test mode, to make sure that yaml files don't have mistakes 

   **jenkins-jobs test jobs**

5.To create or update jobs run the script:
    
   **jenkins-jobs update jobs**

You have to see the output similar to this one:

    INFO:jenkins_jobs.builder:Number of jobs generated:  3
    INFO:jenkins_jobs.builder:Creating jenkins job oshinko-cli-binary-release-jjb 
    INFO:jenkins_jobs.builder:Creating jenkins job oshinko-cli-e2e-nightly-jjb
    INFO:jenkins_jobs.builder:Creating jenkins job oshinko-s2i-e2e-nightly-jjb
    INFO:jenkins_jobs.cli.subcommand.update:Number of jobs updated: 3
    INFO:jenkins_jobs.builder:Number of views generated:  2
    INFO:jenkins_jobs.builder:Creating jenkins view nightly-jjb
    INFO:jenkins_jobs.builder:Creating jenkins view release-jjb
    INFO:jenkins_jobs.cli.subcommand.update:Number of views updated: 2

6.Go to the jenkins page to verify results.


  **Additional options:**
    
  * To delete a specific job run: 
    
    **jenkins-jobs delete \<jobName>**
    
  * To delete all jobs run: 
 
    **jenkins-jobs delete-all -j**
    
  * To delete all views run: 
    
    **jenkins-jobs delete-all -v**