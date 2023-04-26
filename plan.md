catelog:: 
	model: movie - title, descriptiion, genre, imdb rating title as unique id;
		database - mongodb
		uri - 
			add/  Body
			update/{title}
			view/{title}
			delete/{title}
			view/all
		security - client grant type, authorization - public, super
		exception - 
			add -?? incorrect body
			update -?? incorrect body or title
			view -?? incorrect title
			delete -?? incorrect title

schedule::
	model: 
		schedule - date, one slot, two, three 
		smovie - title, price_tier1, price_tier2, price_teir3
	database - mongodb
	uri - 
		add/ should also create slot in booking
		view/{date}

		update/{date} delete/{date}/slot or all
		have effect on booking - title change then cancel, price change then refund

	security- client grant type, authorization - public, super

	exception - 
		add -?? wrong body, title not present
		view -?? incorrect date, schedule not pressent
		update -?? incorrect date, wrong body, title not present
		delete -?? incorrect date, slot not present, schedule not pressent

booking ::
	model-
		Ticket - id, car numbeer, movie, slot, slot number
		slot - date, time, teir1, teir2, teir3
	database - mongodb
	uri - 
		view/title, date, time and or both
		book/ticket
		view/booking
		calcel/

	security - something




