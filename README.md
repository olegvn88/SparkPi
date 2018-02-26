**How to run tests on a local PC**

1. Install and run sshd service by run the scripts:

    **sudo dnf install -y openssh-server** - to install
    
    **sudo systemctl start sshd** - to run ssh service
    
    **sudo systemctl enable sshd** - to add sshd to startup
 
2. Run **oc cluster up --public-hostname <IP_address_of_your_pc> --routing-suffix api.<IP_address_of_your_pc>.nip.io**

3. Create project in openshift, run **oc new-project \<projectName>**  

4. Create **test.properties** file in project directory and put there this text:

        #openshift user
        xtf.config.master.username=<openshift_user_name>
        xtf.config.master.password=<openshift_user_password>
        
        #ip address of the local machine
        xtf.config.domain=<IP_address_of_your_pc>.nip.io
        
        #name of project into openshift
        xtf.config.master.namespace=<projectName>
        
        #ssh credentials
        xtf.config.nfs.ssh_username=<user_name>
        xtf.config.master.ssh_username=<user_name>
        xtf.config.master.ssh_key_path=keys/daikon

5. Run tests.