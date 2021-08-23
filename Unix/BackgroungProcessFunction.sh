launchBackgroundProcess() {
    #do things with parameters like $1 such
    current_time=$(date "+%Y.%m.%d-%H.%M.%S")
    log_name=/LOGDIR/$1_$current_time.log
    echo "Appending to $log_name"
    echo "Command :  nohup /app/apogee/BATCH/bin/run_java.sh $@ > $log_name  &"
	#  adding  & attach the command to the system pid (you can quit the session now)
    nohup /BINDIR/script.sh $@ > $log_name  &
}

